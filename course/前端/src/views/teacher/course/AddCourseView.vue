<template>
  <div id="addCourseContainer">
    <el-form label-width="120px">
      <el-form-item label="课程名称">
        <el-input placeholder="请输入课程名称" v-model="course.courseName"></el-input>
      </el-form-item>
      <el-form-item label="课程学分">
        <el-input placeholder="请输入课程学分" v-model="course.courseCredit"></el-input>
      </el-form-item>
      <el-form-item label="课程考核方式">
        <el-select v-model="course.courseExamMethod">
          <el-option label="考察" value="1"></el-option>
          <el-option label="考试" value="2"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="success" @click="doSave">添加</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>


<script>
  export default{
    name:'AddCourseView',
    data(){
      return{
        course:{
          courseName :'',
          courseCredit :'',
          courseExamMethod :'1'
        }
      }
    },
    methods:{
      doSave(){
        this.$axios.post("CourseInfoController/doSave",this.course)
        .then(rst=>{
          let resultJson = rst.data;
          if(resultJson.code==200){
            this.$message("添加成功！");
          }else{
            this.$message("添加失败！");
          }
        }).catch(err=>{
          console.log(err)
        })
      }
    }
  }
</script>

<style scoped>
  #addCourseContainer{
    width: 500px;
    margin-top: 20px;
    }
   #addCourseContainer .el-select{
     width: 100%;
   }
</style>