<template>
  <v-container>
    <v-layout justify-center>
      <v-flex xs12 sm10 md8 lg6>
        <v-card>
          <v-card-text>
            <v-btn-toggle v-model="schoolType" depressed class="btn-toggle-block" style="margin-bottom: 20px" ref="schoolType">
              <v-btn
                style="width: 33%; display:inline-block"
                v-for="item in schoolTypes"
                :key="item"
                :value="item"
                depressed
                large
                color="blue-grey lighten-4">
                {{ item }}
              </v-btn>
            </v-btn-toggle>

            <v-text-field
              ref="name"
              v-model="name"
              :rules="[() => !!name || 'This field is required']"
              label="이름"
              required
            ></v-text-field>
            <v-text-field
              ref="birth"
              v-model="birth"
              label="생년월일"
              mask="####-##-##"
              required
            ></v-text-field>
            <v-layout row>
              <v-flex xs8>
                <v-text-field
                  ref="schoolName"
                  v-model="schoolName"
                  label="학교"
                  :suffix="schoolType"
                  required
                  justify-center
                ></v-text-field>
              </v-flex>
              <v-flex xs4>
                <v-autocomplete
                  ref="grade"
                  :items="schoolType === '초등학교' ? [1,2,3,4,5,6] : [1,2,3]"
                  v-model="grade"
                  class="ml-3"
                  flat
                  hide-no-data
                  hide-details
                  label="학년"
                  reverse
                ></v-autocomplete>
              </v-flex>
            </v-layout>
            <v-text-field
              ref="phoneNumber"
              v-model="phoneNumber"
              :rules="[() => !!phoneNumber || 'This field is required']"
              label="핸드폰 번호"
              mask="###-####-####"
              required
            ></v-text-field>
            <v-text-field
              ref="parentPhoneNumber"
              :rules="[() => !!parentPhoneNumber || 'This field is required']"
              v-model="parentPhoneNumber"
              label="학부모님 번호"
              mask="###-####-####"
              required
            ></v-text-field>
            <v-text-field
              ref="address"
              v-model="address"
              label="주소"
              required
            ></v-text-field>
          </v-card-text>
          <v-divider class="mt-3"></v-divider>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="primary" flat @click="submit">Submit</v-btn>
          </v-card-actions>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  name: 'StudentManagement',
  data: () => ({
    name: '',
    birth: null,
    schoolName: null,
    schoolType: '초등학교',
    grade: null,
    phoneNumber: null,
    parentPhoneNumber: null,
    address: null,
    formHasErrors: null,
    schoolTypes: [
      '초등학교', '중학교', '고등학교',
    ],
  }),
  computed: {
    form() {
      return {
        name: this.name,
        birth: this.birth,
        schoolName: this.schoolName,
        schoolType: this.schoolType,
        grade: this.grade,
        phoneNumber: this.phoneNumber,
        parentPhoneNumber: this.parentPhoneNumber,
        address: this.address,
      };
    },
  },
  methods: {
    submit() {
      this.formHasErrors = false;

      Object.keys(this.form).forEach((f) => {
        if (!this.form[f]) this.formHasErrors = true;
      });

      if (!this.formHasErrors) {
        this.$http.post('/api/students/register', this.form);
      }
    },
  },
};
</script>

<style>
  .btn-toggle-block {
    display: block;
    box-shadow: none;
  }
</style>
