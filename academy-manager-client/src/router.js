import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import StudentManagement from './views/StudentManagement.vue';
import TeacherManagement from './views/TeacherManagement.vue';

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/student/manage',
      name: 'student-management',
      component: StudentManagement,
    },
    {
      path: '/teacher/manage',
      name: 'teacher-management',
      component: TeacherManagement,
    },
    {
      path: '/payment/manage',
      name: 'payment-management',
      component: TeacherManagement,
    },
    {
      path: '/lecture/manage',
      name: 'lecture-management',
      component: TeacherManagement,
    },
    {
      path: '/teaching-material/manage',
      name: 'teaching-material-management',
      component: TeacherManagement,
    },
    {
      path: '/contract',
      name: 'contract',
      component: TeacherManagement,
    },
  ],
});
