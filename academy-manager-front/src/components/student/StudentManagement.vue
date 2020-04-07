<template>
  <v-container fluid>
    <v-card>
      <v-card-title>
        <v-text-field
          v-model="search"
          append-icon="search"
          label="Search"
          single-line
          hide-details
        ></v-text-field>
        <v-spacer></v-spacer>
        <v-btn outline color="indigo" @click="register" to="/student/register">
          <v-icon dark left>edit</v-icon>
          신입생 등록
        </v-btn>
      </v-card-title>
      <v-data-table
        :headers="headers"
        :items="students"
        hide-actions
        item-key="name"
        :search="search"
      >
        <template slot="headers" slot-scope="props">
          <tr>
            <th
              v-for="header in props.headers"
              :key="header.text"
            >
              {{ header.text }}
            </th>
          </tr>
        </template>
        <template slot="items" slot-scope="props">
          <tr @click="showDetail(props.item)" class="pointer">
            <td class="text-xs-center">{{ props.item.name }}</td>
            <td class="text-xs-center">
              <v-chip outline disabled :color="props.item.type.code === '초등' ? 'indigo'
              : props.item.type.code === '중학' ? 'green' : 'pink'">{{ props.item.type.code }}
              </v-chip>
            </td>
            <td class="text-xs-center">{{ props.item.registerType }}</td>
            <td class="text-xs-center">{{ props.item.originPrice ? props.item.originPrice.toLocaleString() : '' }}</td>
            <td class="text-xs-center">{{ props.item.discountPrice ? props.item.discountPrice.toLocaleString() : '' }}</td>
            <td class="text-xs-center">{{ props.item.finalPrice ? props.item.finalPrice.toLocaleString() : '' }}</td>
            <td class="text-xs-center">{{ props.item.registeredAt | moment("YYYY-MM-DD")}}</td>
            <td class="text-xs-center">{{ props.item.notes}}</td>
          </tr>
        </template>
        <v-alert slot="no-results" :value="true" color="error" icon="warning">
          "<b> {{ search }} </b>" 에 대한 검색 결과가 없습니다
        </v-alert>
      </v-data-table>
    </v-card>
  </v-container>
</template>

<style scoped>
  .pointer {
    cursor: pointer;
  }
</style>

<script>
export default {
  name: 'StudentManagement',
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
    const vm = this;
    this.$http.get('/api/students').then((response) => {
      vm.students = response.data;
    });
  },
  methods: {
    register() {

    },
    showDetail(item) {
      this.$router.push({
        name: 'student-detail',
        params: { studentId: item.studentId },
      });
    },
  },
};
</script>
