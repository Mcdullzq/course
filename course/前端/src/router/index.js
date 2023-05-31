import AboutView from '@/views/AboutView'
import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import teas from './teacher'
import stus from "@/router/student";

const routes = [
    ...teas,
    {
        path:'/about',
        component:AboutView
    },
    ...stus
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
