<template>
    <div id="container">
      <div id="login-container">
        <h2>在校选课系统<br>学生端</h2>
        <el-form size="large">
          <el-form-item>
             <el-input placeholder="编号\邮箱" v-model="stu.loginName">
               <template #prepend>账号</template>
             </el-input>
          </el-form-item>
          <el-form-item>
            <el-input placeholder="密码" type="password" v-model="stu.loginPwd">
              <template #prepend>密码</template>
            </el-input>
          </el-form-item>
          <el-form-item>
            <div class="center">
              <el-button type="success" @click="doLogin">登录</el-button>
            </div>
          </el-form-item>
          <el-form-item>
            <div class="right">
              <router-link to="">忘记密码</router-link>
            </div>
          </el-form-item>
        </el-form>
      </div>
    </div>

  <!-- 登录失败 的对话框 -->
  <el-dialog
      v-model="centerDialogVisible"
      title="提示"
      width="30%"
      align-center
  >
    <span>账号或密码有误！</span>
    <template #footer>
	      <span class="dialog-footer">
	        <el-button @click="centerDialogVisible = false">确定</el-button>
	      </span>
    </template>
  </el-dialog>
</template>

<script>
  export default {
    name:'LoginView',
    data(){
      return{
        stu:{
          loginName:'',
          loginPwd:''
        },
        centerDialogVisible:false
      }
    },
    methods:{
      doLogin(){
        this.$axios.post("StuInfoController/Login",this.stu)
        .then(rst=>{
          let result = rst.data;
          if(!result.data)
          {
            this.centerDialogVisible=true;
          }else{
            this.$router.push("/stuMain");
            let str = JSON.stringify(result.data);
            sessionStorage.setItem("stu",str);
          }
        }).catch(err=>{
          console.log(err);
        })
      }
    }
  }
</script>

<style scoped>
    #container{
      background-image: url("../../assets/a.jpg");
      width: 100%;
      height: 100%;
      background-repeat: no-repeat;
      background-size: 100%;
      background-position: center;
      display: flex;
      justify-content: right;
      align-items: center;
    }
    #login-container{
      width: 400px;
      background-color: #b8daff;
      border: 1px white solid;
      border-radius: 20px;
      padding: 20px 60px;
      box-shadow: black 15px 15px 5px ;
      margin-right: 300px;
    }
    #login-container h2{
      font-size: 40px;
      color: white;
      font-family: 楷体;
      text-align: center;
      margin: 20px;
      text-shadow: black 5px 5px 5px;
    }
    #login-container .center{
      text-align: center;
      width: 100%;
      height: 100%;
    }
    #login-container .right{
      width: 100%;
      height: 100%;
      text-align: right;
      margin-top: -20px;
    }
</style>