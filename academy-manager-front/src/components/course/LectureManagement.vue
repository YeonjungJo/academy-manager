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
        <v-btn outline color="indigo" @click.stop="showRegisterForm=true">
          <LectureRegistration :visible="showRegisterForm" @close="showRegisterForm=false" :options="options"/>
          <v-icon dark left>edit</v-icon>
          수강 타입 추가
        </v-btn>
      </v-card-title>
      <v-data-table
        :headers="headers"
        :items="courses"
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
          <tr>
            <td class="text-xs-center">{{ props.item.courseName}}</td>
            <td class="text-xs-center">
              <v-chip outline disabled :color="props.item.type.code === '초등' ? 'indigo'
              : props.item.type.code === '중학' ? 'green' : 'pink'">{{ props.item.type.code }}
              </v-chip>
            </td>
            <td class="text-xs-center">{{ props.item.eng === 0 ? '' : props.item.eng}}</td>
            <td class="text-xs-center">{{ props.item.math === 0 ? '' : props.item.math}}</td>
            <td class="text-xs-center">{{ props.item.discuss === 0 ? '' : props.item.discuss}}</td>
            <td class="text-xs-center">{{ props.item.price ? props.item.price.toLocaleString() : '' }}</td>
          </tr>
        </template>
      </v-data-table>
    </v-card>
  </v-container>
</template>

<style scoped>
</style>

<script>
import LectureRegistration from './LectureRegistration';

export default {
  name: 'LectureManagement',
  components: { LectureRegistration },
  data: () => ({
    search: '',
    options: {},
    headers: [{ text: '이름', value: 'courseName' }, { text: '초/중/고', value: 'type' }, {
      text: '영어 (시간/주)', value: 'eng',
    }, { text: '수학 (시간/주)', value: 'math' }, { text: '토론 (시간/주)', value: 'discuss' }, { text: '수강료 (원)', value: 'price' }],
    courses: [],
    showRegisterForm: false,
  }),
  created() {
    const vm = this;
    this.$http.get('/api/courses').then((response) => {
      vm.courses = response.data;
    });
    this.$http.get('/api/courses/options').then((response) => {
      vm.options = response.data;
    });
  },
};
</script>
<style>
  tr > td {
    border-right: 1px dotted rgba(0, 0, 0, .05);
  }

  tr:last-child {
    border: none;
  }
</style>
