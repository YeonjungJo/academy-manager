<template>
  <v-dialog v-model="show" max-width="600px">
    <v-card>
      <v-card-title>
        <h2>수강 타입 추가</h2>
      </v-card-title>
      <v-divider class="mt-3"></v-divider>
      <v-card-text>
        <v-row>
          <v-overflow-btn
            v-model="schoolType"
            class="my-2"
            :items="schoolTypes"
            overflow
          ></v-overflow-btn>
          <v-text-field
            ref="name"
            v-model="name"
            :rules="[() => !!name || 'This field is required']"
            label="이름"
            required
          ></v-text-field>
        </v-row>
        <v-simple-table>
          <tr v-for="subject in subjects" :key="subject.text">
            <td>
              <v-checkbox v-model="subject.checked" :label="subject.text"></v-checkbox>
            </td>
            <td>
              <v-text-field
                v-model="subject.assign"
                required="subject.checked"
                sm="6"
                solo
              >
              </v-text-field>
            </td>
          </tr>
        </v-simple-table>
        <v-text-field
          ref="price"
          v-model="price"
          label="수강료"
          required
        ></v-text-field>
      </v-card-text>
      <v-divider class="mt-3"></v-divider>

      <v-card-actions>
        <v-btn color="primary" flat @click="show=false">Close</v-btn>
        <v-spacer></v-spacer>
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
      };
    },
  },
  data: () => ({
    schoolType: '',
    schoolTypes: [
      { text: '초등' },
      { text: '중학' },
      { text: '고등' },
    ],
    subjects: [
      { text: '영어', checked: false, assign: 0 },
      { text: '수학', checked: false, assign: 0 },
      { text: '토론', checked: false, assign: 0 },
    ],
    name: '',
    assigned: {},
    price: null,
  }),
  methods: {
    submit() {
      this.formHasErrors = false;

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
