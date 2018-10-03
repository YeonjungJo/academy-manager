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
        <v-btn outline color="indigo">
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
              <v-chip outline disabled color="indigo">{{ props.item.type.description }}</v-chip>
            </td>
            <td class="text-xs-center">{{ props.item.eng}}</td>
            <td class="text-xs-center">{{ props.item.math}}</td>
            <td class="text-xs-center">{{ props.item.discuss}}</td>
            <td class="text-xs-center">{{ props.item.price}}</td>
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
</style>

<script>
export default {
  name: 'CourseAdjustment',
  data: () => ({
    search: '',
    headers: [
      { text: '종류', value: 'courseName' },
      { text: '초/중/고', value: 'type' },
      { text: '영어', value: 'eng' },
      { text: '수학', value: 'math' },
      { text: '토론', value: 'discuss' },
      { text: '수강료', value: 'price' },
    ],
    courses: [],
  }),
  created() {
    const vm = this;
    this.$http.get('/api/courses').then((response) => {
      console.log(response.data);
      vm.courses = response.data;
    });
  },
};
</script>
