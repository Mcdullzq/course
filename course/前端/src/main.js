import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import zhCn from 'element-plus/dist/locale/zh-cn.mjs'
import axios from 'axios'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'


let app = createApp(App)
axios.defaults.baseURL="http://localhost:8088/stuselectsystem/";
app.config.globalProperties.$axios = axios

app.use(router).use(ElementPlus,{locale:zhCn}).mount('#app')
for (const [key,component] of Object.entries(ElementPlusIconsVue)){
    app.component(key,component)
}