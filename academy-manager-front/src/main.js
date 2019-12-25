import Vue from 'vue';
import axios from 'axios';

import 'roboto-fontface/css/roboto/roboto-fontface.css';
import 'material-design-icons-iconfont/dist/material-design-icons.css';

import vuetify from './plugins/vuetify';
import App from './App';
import router from './router';

Vue.config.productionTip = false;
Vue.prototype.$http = axios;

Vue.use(vuetify);

new Vue({
  vuetify,
  // el: '#app',
  components: { App },
  template: '<App/>',
  router,
  render: h => h(App),
}).$mount('#app');
