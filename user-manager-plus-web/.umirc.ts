import { defineConfig } from 'umi';

export default defineConfig({
  history: {
    type: 'memory'
  },
  routes: [
    {
      path: '/login',
      component: '@/pages/Login',
      exact: true
    },
    {
      path: '/toLogin',
      component: '@/pages/Login',
      exact: true
    },
    {
      path: '/',
      component: '@/layouts/index',
      routes: [
        {
          path: '/',
          component: '@/pages/index'
        },
        {
          path: '/index',
          component: '@/pages/index'
        },
        {
          path: '/users',
          component: '@/pages/UserTable'
        },
        {
          path: '/students',
          component: '@/pages/StudentTable'
        },
        {
          path: '/addUser',
          component: '@/pages/AddUser'
        },
        {
          path: '/addStudent',
          component: '@/pages/AddStudent'
        }
      ]
    },

  ],
  proxy: {
    '/hetong/*': {
      target: 'http://127.0.0.1:8091',
      changeOrigin: true
    },
    '/checkLogin': {
      target: 'http://127.0.0.1:8091',
      changeOrigin: true
    },
    '/login': {
      target: 'http://127.0.0.1:8091',
      changeOrigin: true
    },
    '/logout':{
      target: 'http://127.0.0.1:8091',
      changeOrigin: true
    },
    // '/log/*': {
    //   target: 'http://127.0.0.1:8091',
    //   changeOrigin: true
    // },
    '/user/*': {
      target: 'http://127.0.0.1:8091',
      changeOrigin: true
    },
    '/student/*': {
      target: 'http://127.0.0.1:8091',
      changeOrigin: true
    },
    '/batch/*': {
      target: 'http://127.0.0.1:8091',
      changeOrigin: true
    }
  }
});
