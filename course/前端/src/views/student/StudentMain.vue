<template>
  <div id="container">
    <div id="top">
      <div id="top_left">大学生在校选课系统</div>
      <div id="top_right">
        <span>欢迎【{{stu.stuName}}】登录</span>
        <router-link to="#" @click="exit">注销</router-link>
      </div>
    </div>
    <div id="center">
      <div id="left">
        <el-menu :unique-opened="true"  background-color="antiquewhite" router >
          <el-sub-menu index="1">
            <template #title>
              <el-icon><Tickets /></el-icon>
              <span style="font-size: 18px">查询课程信息</span>
            </template>
            <el-menu-item index="/unSelectedCourse">查询可选课程</el-menu-item>
            <el-menu-item index="/selectedCourse">查询已选课程</el-menu-item>
          </el-sub-menu>

          <el-sub-menu index="6" >
            <template #title>
              <el-icon><Promotion /></el-icon>
              <span style="font-size: 18px">设置个人信息</span>
            </template>
            <el-menu-item index="/stuInfo">显示个人信息</el-menu-item>
            <el-menu-item index="6-2">修改头像</el-menu-item>
            <el-menu-item index="/updateStuPwdView">修改密码</el-menu-item>
            <el-menu-item index="/updateStuInfoView">修改个人信息</el-menu-item>
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
  name: 'StudentMain',
  data(){
    return{
      stu:{}
    }
  },
  created() {
    let str = sessionStorage.getItem("stu");
    if(!str){
      this.$router.push("/stuLogin");
    }else {
      this.stu = JSON.parse(str)
    }

  },
  methods:{
    exit(){
      sessionStorage.removeItem("stu");
      this.$router.push("/stuLogin");
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