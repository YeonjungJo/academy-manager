import Vue from 'vue';
import Router from 'vue-router';
import Home from '@/components/Home';
import StudentManagement from '@/components/student/StudentManagement';
import StudentRegistration from '@/components/student/StudentRegistration';
import StudentDetail from '@/components/student/StudentDetail';
import TeacherManagement from '@/components/teacher/TeacherManagement';
import LectureManagement from '@/components/course/LectureManagement';

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
      path: '/student/details',
      name: 'student-detail',
      component: StudentDetail,
      props: true,
    },
    {
      path: '/student/register',
      name: 'student-register',
      component: StudentRegistration,
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
      component: LectureManagement,
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
