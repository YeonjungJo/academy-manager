import Vue from 'vue';
import axios from 'axios';
import VueMoment from 'vue-moment';

import 'roboto-fontface/css/roboto/roboto-fontface.css';
import 'material-design-icons-iconfont/dist/material-design-icons.css';

import './plugins/vuetify';
import App from './App';
import router from './router';

Vue.config.productionTip = false;
Vue.prototype.$http = axios;
Vue.use(VueMoment);

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
});
