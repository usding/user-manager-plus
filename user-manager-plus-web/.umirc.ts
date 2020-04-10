import { defineConfig } from 'umi';

export default defineConfig({
  routes: [
    {
      path: '/login',
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
    }
  }
});
