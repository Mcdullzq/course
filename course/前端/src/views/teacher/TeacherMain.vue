<template>
  <div id="container">
    <div id="top">
      <div id="top_left">大学生在校选课系统</div>
      <div id="top_right">
        <span>欢迎【{{tea.teaName}}】登录</span>
        <router-link to="#" @click="exit">注销</router-link>
      </div>
    </div>
    <div id="center">
      <div id="left">
        <el-menu :unique-opened="true"  background-color="antiquewhite" router >
          <el-sub-menu index="1" v-if="tea.teaType==1">
            <template #title>
              <el-icon><location /></el-icon>
              <span style="font-size: 18px">教室信息维护</span>
            </template>
            <el-menu-item index="/addClassroom">添加教室</el-menu-item>
            <el-menu-item index="/searchClassroom">查询教室</el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="2" v-if="tea.teaType==1">
            <template #title>
              <el-icon><Star /></el-icon>
              <span style="font-size: 18px">课程信息维护</span>
            </template>
            <el-menu-item index="/addCourse">添加课程</el-menu-item>
            <el-menu-item index="/searchCourse">查询课程</el-menu-item>
            <el-menu-item index="/resetDeleteCourse">批量恢复课程</el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="3" v-if="tea.teaType==1">
            <template #title>
              <el-icon><Odometer /></el-icon>
              <span style="font-size: 18px">教师信息维护</span>
            </template>
            <el-menu-item index="/addTeacher">添加教师</el-menu-item>
            <el-menu-item index="/searchTeacher">查询教师</el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="4" v-if="tea.teaType==1">
            <template #title>
              <el-icon><Avatar /></el-icon>
              <span style="font-size: 18px">排课信息维护</span>
            </template>
            <el-menu-item index="/addTC">添加排课</el-menu-item>
            <el-menu-item index="/searchTC">查询排课</el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="5" v-if="tea.teaType==1">
            <template #title>
              <el-icon><Grid /></el-icon>
              <span style="font-size: 18px">学生信息维护</span>
            </template>
            <el-menu-item index="/addStuView">添加学生信息</el-menu-item>
            <el-menu-item index="/searchStuView">查询学生信息</el-menu-item>
            <el-menu-item index="/addBatchStusView">批量添加学生信息</el-menu-item>
          </el-sub-menu>

          <el-sub-menu index="7" v-if="tea.teaType==2">
            <template #title>
              <el-icon><Grid /></el-icon>
              <span style="font-size: 18px">授课信息查询</span>
            </template>
            <el-menu-item index="/searchSKView">查询授课信息</el-menu-item>
            <el-menu-item index="/searchStuSKView">查询学生信息</el-menu-item>
          </el-sub-menu>

          <el-sub-menu index="6" >
            <template #title>
              <el-icon><Promotion /></el-icon>
              <span style="font-size: 18px">设置个人信息</span>
            </template>
            <el-menu-item index="/showInfoView">显示个人信息</el-menu-item>
            <el-menu-item index="6-2">修改头像</el-menu-item>
            <el-menu-item index="/updatePwdView">修改密码</el-menu-item>
            <el-menu-item index="/updateInfoView">修改个人信息</el-menu-item>
          </el-sub-menu>
        </el-menu>

      </div>
      <div id="right">
        <router-view></router-view>
      </div>
    </div>
    <div id="bottom">
      项目运行过程中有疑问请联系管理员
    </div>
  </div>
</template>

<script>
export default {
  name: "TeacherMain",
  data(){
    return{
      tea:{}
    }
  },
  created() {
    let str = sessionStorage.getItem("tea");
    if(!str){
      this.$router.push("/login");
    }else {
      this.tea = JSON.parse(str)
    }

  },
  methods:{
    exit(){
      sessionStorage.removeItem("tea");
      this.$router.push("/login");
    }
  }
}
</script>

<style scoped>
  #container{
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    background-image: url("../../assets/b.jpg");
    background-repeat: no-repeat;
    background-size: 100% 100%;
    background-position: center;
  }
  #top{
    background-color: #b8daff;
    width: 100%;
    height: 80px;
    border-bottom: 1px solid gray;
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  #top_left{
    margin-left: 30px;
    font-size: 45px;
    font-family: 楷体;
    text-shadow: 5px 5px 5px gray;
  }
  #top_right{
    margin-right: 20px;
  }
  #top_right span{
    margin-right: 5px;
  }
  #bottom{
    width: 100%;
    height: 30px;
    border-top: 1px solid gray;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 12px;
    color: gray;
    background-color: aliceblue;
  }
  #center{
    width: 100%;
    flex: 1;
    display: flex;
    flex-direction: row;
  }
  #left{
    height: 100%;
    width: 200px;
    border-right: 1px solid gray;
    background-color: antiquewhite;
  }
  #right{
    flex:1;
    height: 100%;
  }
</style>