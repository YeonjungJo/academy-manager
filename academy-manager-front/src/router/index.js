import Vue from 'vue';
import Router from 'vue-router';
import Home from '@/components/Home';
import StudentManagement from '@/components/StudentManagement';
import TeacherManagement from '@/components/TeacherManagement';

Vue.use(Router);

export default new Router({
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
