<template>
  <v-app>
    <v-navigation-drawer
      persistent
      :mini-variant="miniVariant"
      :clipped="clipped"
      v-model="drawer"
      fixed
      app
    >
      <v-list>
        <v-list-item
          v-for="(item, i) in items"
          :key="i"
          :to="item.url"
          @click.prevent="title = item.title"
        >
          <v-list-tile-action>
            <v-icon v-html="item.icon"></v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title v-text="item.title"></v-list-tile-title>
          </v-list-tile-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-app-bar
      app
      :clipped-left="clipped"
      color="blue-grey darken-3"
      dark>
      <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>

      <v-toolbar-title v-text="title"></v-toolbar-title>
      <v-spacer></v-spacer>
    </v-app-bar>

    <v-content>
      <router-view/>
    </v-content>

    <!--<v-footer :fixed="fixed" app>-->
    <!--<span>&copy; 2017</span>-->
    <!--</v-footer>-->
  </v-app>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      clipped: false,
      drawer: true,
      items: [
        { icon: 'home', title: 'HOME', url: '/home' },
        { icon: 'add_circle_outline', title: '신입생 등록', url: '/student/register' },
        { icon: 'face', title: '원생관리', url: '/student/manage' },
        // { icon: 'person', title: '강사관리', url: '/teacher/manage' },
        // { icon: 'payment', title: '결제관리', url: '/payment/manage' },
        { icon: 'dashboard', title: '수업관리', url: '/lecture/manage' },
        // { icon: 'library_books', title: '교재비관리', url: '/teaching-material/manage' },
        // { icon: 'attach_money', title: '수강료조정', url: '/tuition/adjust' },
        // { icon: 'phone', title: '연락망조회', url: '/contract' },
      ],
      miniVariant: false,
      title: 'Enable',
    };
  },
};
</script>
