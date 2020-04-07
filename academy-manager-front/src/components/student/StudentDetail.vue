<template>
  <v-container fluid grid-list-md>
    <v-layout row wrap>
      <v-flex>
        <v-card>
          <v-card-title primary-title><div class="headline">기본정보</div></v-card-title>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<style scoped>
</style>

<script>
export default {
  name: 'StudentDetail',
  data: () => ({
    search: '',
    headers: [
      { text: '성명', align: 'center', value: 'name' },
      { text: '초/중/고', value: 'type' },
      { text: '등록', value: 'registerType' },
      { text: '원비 (원)', value: 'originPrice' },
      { text: '할인금액 (원)', value: 'discountPrice' },
      { text: '합계 (원)', value: 'finalPrice' },
      { text: '등록일', value: 'registeredAt' },
      { text: '비고', value: 'notes' },
    ],
    students: [],
  }),
  created() {
    this.studentId = this.$route.params.studentId;
    if (!this.studentId) {
      this.$router.push({ name: 'student-management' });
    }
    const vm = this;
    this.$http.get('/api/students').then((response) => {
      vm.students = response.data;
    });
  },
  methods: {
    register() {

    },
    showDetail() {
    },
  },
};
</script>
