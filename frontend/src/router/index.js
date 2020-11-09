import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: () => import('@/views/Home'),
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
    {
      path: '/post/create',
      name: 'PostCreate',
      component: () => import('@/views/PostCreate'),
    },
  ],
});
