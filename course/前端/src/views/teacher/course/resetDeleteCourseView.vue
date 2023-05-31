<template>
  <div id="resetCourseContainer">
    <div>
      <el-button @click="doReset">批量恢复</el-button>
    </div>
    <el-table :data="courses" border
              @selection-change="handlerSelectChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column label="编号" prop="courseId"></el-table-column>
      <el-table-column label="课程名称" prop="courseName"></el-table-column>
      <el-table-column label="学分" prop="courseCredit"></el-table-column>
      <el-table-column label="考核方式">
        <template #default="scope">
          {{scope.row.courseExamMethod==1?'考察':'考试'}}
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "resetDeleteCourseView",
  data(){
    return{
      course:{
        courseStatus: 2
      },
      courses:[],
      ids:[]
    }
  },
  methods:{
    handlerSelectChange(rows){
      for(let i in rows){
        this.ids.push(rows[i].courseId);
      }
    },
    doReset(){
      if(this.ids.length==0){
        this.$message("请选择要恢复的课程");
      }else {
        this.$axios.post("CourseInfoController/resetCourseStatus",this.ids)
        .then(rst=>{
          let resultJson = rst.data;
          if(resultJson.code==200){
            this.$message("操作成功！");
            this.$axios.post("CourseInfoController/findByParam",this.course)
                .then(rst=>{
                  this.courses=rst.data.data;
                }).catch(err=>{
              console.log(err);
            })
          }else{
            this.$message("操作失败!");
          }
        })
      }
    }
  },
  created() {
    this.$axios.post("CourseInfoController/findByParam",this.course)
        .then(rst=>{
          this.courses=rst.data.data;
        }).catch(err=>{
      console.log(err);
    })
  }
}
</script>

<style scoped>
  #resetCourseContainer{
    margin: 20px;
  }

  #resetCourseContainer div{
    margin-bottom: 20px;
  }
</style>