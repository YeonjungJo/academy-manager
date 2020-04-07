<template>
  <v-dialog v-model="show" max-width="600px">
    <v-card>
      <v-card-title>
        <h2>수강 타입 추가</h2>
      </v-card-title>
      <v-divider class="mt-3"/>
      <v-card-text>
        <v-overflow-btn
          v-model="schoolType"
          :items="schoolTypes"
        />
        <v-text-field
          ref="name"
          v-model="name"
          :rules="[() => !!name || 'This field is required']"
          label="이름"
          required
        />
        <v-text-field
          ref="price"
          v-model="price"
          label="수강료"
          required
        />
        <v-table-overflow>
          <td v-for="subject in subjects" :key="subject.text">
            <v-autocomplete
              class="px-1"
              :items="assignRange"
              v-model="subject.assign"
              :label="subject.text"
              autocomplete/>
          </td>
        </v-table-overflow>
      </v-card-text>
      <v-divider class="mt-3"/>

      <v-card-actions>
        <v-btn color="primary" flat @click="show=false">Close</v-btn>
        <v-spacer/>
        <v-btn color="primary" flat @click="submit">Submit</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: 'LectureRegistration',
  props: ['visible', 'options'],
  computed: {
    show: {
      get() {
        return this.visible;
      },
      set(value) {
        if (!value) {
          this.$emit('close');
        }
      },
    },
    form() {
      return {
        name: this.name,
        price: this.price,
        schoolType: this.schoolType,
        // assigned: this.subjects.reduce((acc, target) => ({...acc, [target]})),
      };
    },
  },
  data: () => ({
    schoolType: '초등',
    schoolTypes: [
      { text: '초등' },
      { text: '중학' },
      { text: '고등' },
    ],
    subjects: [
      { text: '영어', assign: 0 },
      { text: '수학', assign: 0 },
      { text: '토론', assign: 0 },
    ],
    name: '',
    price: null,
    assignRange: Array(5).fill().map((x, i) => i),
  }),
  methods: {
    submit() {
      this.formHasErrors = false;

      console.log(this.form);

      Object.keys(this.form).forEach((f) => {
        if (!this.form[f]) this.formHasErrors = true;
      });

      if (!this.formHasErrors) {
        this.$http.post('/api/courses/register', this.form);
      }
    },
  },
};
</script>

<style scoped>

</style>
