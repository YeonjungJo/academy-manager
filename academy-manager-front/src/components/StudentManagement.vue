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
          <v-icon dark left>edit</v-icon> 신입생 등록
        </v-btn>
      </v-card-title>
      <v-data-table
        :headers="headers"
        :items="desserts"
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
            <td>{{ props.item.name }}</td>
            <td class="text-xs-center">{{ props.item.calories }}</td>
            <td class="text-xs-center">{{ props.item.protein }}</td>
            <td class="text-xs-center">{{ props.item.iron }}</td>
            <td class="text-xs-center">{{ props.item.calories }}</td>
            <td class="text-xs-center">{{ props.item.calories }}</td>
            <td class="text-xs-center">{{ props.item.fat }}</td>
            <td class="text-xs-center">{{ props.item.carbs }}</td>
            <td class="text-xs-center">{{ props.item.protein }}</td>
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
  name: 'StudentManagement',
  data: () => ({
    search: '',
    headers: [
      { text: '성명', align: 'left', value: 'name' },
      { text: '초/중/고', value: 'calories' },
      { text: '등록일(영)', value: 'carbs' },
      { text: '등록일(수)', value: 'carbs' },
      { text: '등록', value: 'protein' },
      { text: '원비', value: 'iron' },
      { text: '할인금액', value: 'iron' },
      { text: '합계', value: 'iron' },
      { text: '비고', value: 'iron' },
    ],
    desserts: [
      {
        value: false,
        name: 'Frozen Yogurt',
        calories: 159,
        fat: 6.0,
        carbs: 24,
        protein: 4.0,
        iron: '1%',
      },
      {
        value: false,
        name: 'Ice cream sandwich',
        calories: 237,
        fat: 9.0,
        carbs: 37,
        protein: 4.3,
        iron: '1%',
      },
      {
        value: false,
        name: 'Eclair',
        calories: 262,
        fat: 16.0,
        carbs: 23,
        protein: 6.0,
        iron: '7%',
      },
      {
        value: false,
        name: 'Cupcake',
        calories: 305,
        fat: 3.7,
        carbs: 67,
        protein: 4.3,
        iron: '8%',
      },
      {
        value: false,
        name: 'Gingerbread',
        calories: 356,
        fat: 16.0,
        carbs: 49,
        protein: 3.9,
        iron: '16%',
      },
      {
        value: false,
        name: 'Jelly bean',
        calories: 375,
        fat: 0.0,
        carbs: 94,
        protein: 0.0,
        iron: '0%',
      },
      {
        value: false,
        name: 'Lollipop',
        calories: 392,
        fat: 0.2,
        carbs: 98,
        protein: 0,
        iron: '2%',
      },
      {
        value: false,
        name: 'Honeycomb',
        calories: 408,
        fat: 3.2,
        carbs: 87,
        protein: 6.5,
        iron: '45%',
      },
      {
        value: false,
        name: 'Donut',
        calories: 452,
        fat: 25.0,
        carbs: 51,
        protein: 4.9,
        iron: '22%',
      },
      {
        value: false,
        name: 'KitKat',
        calories: 518,
        fat: 26.0,
        carbs: 65,
        protein: 7,
        iron: '6%',
      },
    ],
  }),
  created() {
    this.$http.get('api').then((response) => {
      console.log(response);
      console.log(response.data);
    });
  },
};
</script>
