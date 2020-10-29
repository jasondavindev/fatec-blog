import Vue from 'vue';
import Router from 'vue-router';
import HelloWorld from '@/components/HelloWorld';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld,
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import('@/views/Login'),
    },
    {
      path: '/posts',
      name: 'Posts',
      component: () => import('@/views/Posts'),
    },
    {
      path: '/posts/:id',
      name: 'PostView',
      component: () => import('@/components/PostView'),
    },
  ],
});
