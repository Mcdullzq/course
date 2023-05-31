<template>
  <div id="searchCourseContainer">
    <div id="searchCourseContent">
      <el-form :inline="true">
        <el-form-item label="课程名称:">
          <el-input v-model="course.courseName"></el-input>
        </el-form-item>
        <el-form-item label="课程学分">
          <el-col span="11">
            <el-input v-model="course.minCredit"></el-input>
          </el-col>
          <el-col span="2">
            <div style="text-align: center">--</div>
          </el-col>
          <el-col span="11">
            <el-input v-model="course.maxCredit"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="课程考察方式">
          <el-select v-model="course.courseExamMethod">
            <el-option label="所有方式" value="0"></el-option>
            <el-option label="考察" value="1"></el-option>
            <el-option label="考试" value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="课程状态">
          <el-select v-model="course.courseStatus">
            <el-option label="所有课程" value="0"></el-option>
            <el-option label="可用" value="1"></el-option>
            <el-option label="弃用" value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button @click="search">搜索</el-button>
        </el-form-item>
      </el-form>
    </div>

    <div id="searchCourseResult">
      <el-table :data="courses" border>
        <el-table-column label="编号" prop="courseId"></el-table-column>
        <el-table-column label="课程名称" prop="courseName"></el-table-column>
        <el-table-column label="学分" prop="courseCredit"></el-table-column>
        <el-table-column label="考核方式">
          <template #default="scope">
            {{scope.row.courseExamMethod==1?'考察' :'考试'}}
          </template>
        </el-table-column>
        <el-table-column label="课程状态">
          <template #default="scope">
            {{scope.row.courseStatus==1?'可用':'弃用'}}
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template #default="scope">
            <router-link to="#" @click="showEditDialog(scope.row)">编辑</router-link>
            <router-link to="#" @click="showDeleteDialog(scope.row)">弃用</router-link>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>

  <!--确认是否删除对话框 -->

  <el-dialog
      v-model="deleteDialogVisible"
      title="提示"
      width="30%"
      align-center
  >
    <span>你确定要删除【{{param.courseName}}】么？</span>
    <template #footer>
<span class="dialog-footer">
<el-button @click="deleteDialogVisible = false">取消</el-button>
<el-button type="primary" @click="doDelete">
确定
</el-button>
</span>
    </template>
  </el-dialog>

  <!-- 修改对话框-->
  <el-dialog
      v-model="editDialogVisible"
      title="编辑"
      width="30%"
      align-center
  >
    <div id="editCourseContainer">
      <el-form label-width="120px">
        <el-form-item label="课程名称:">
          <el-input placeholder="请输入课程名称" v-model="param.courseName"></el-input>
        </el-form-item>
        <el-form-item label="课程学分:">
          <el-input placeholder="请输入课程学分" v-model="param.courseCredit"></el-input>
        </el-form-item>
        <el-form-item label="课程考核方式:">
          <el-select v-model="param.courseExamMethod">
            <el-option label="考察" :value="1"></el-option>
            <el-option label="考试" :value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="课程状态:">
          <el-select v-model="param.courseStatus">
            <el-option label="可用" :value="1"></el-option>
            <el-option label="弃用" :value="2"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
    </div>
    <template #footer>
	        <span class="dialog-footer">
	          <el-button @click="editDialogVisible = false">取消</el-button>
	          <el-button type="primary" @click="doEdit">
	            确定
	          </el-button>
	        </span>
    </template>
  </el-dialog>
</template>

<script>
export default {
  name: "SearchCourseView",
  data(){
    return{
      course:{
        courseName :'',
        minCredit :'',
        maxCredit :'',
        courseExamMethod :'0',
        courseStatus :'0'
      },
      courses:[],
      deleteDialogVisible:false,
      param:{},
      editDialogVisible:false
    }
  },
  methods:{
    search(){
      this.$axios.post("CourseInfoController/findByParam",this.course)
      .then(rst=>{
        this.courses=rst.data.data;
      }).catch(err=>{
        console.log(err);
      })
    },
    showDeleteDialog(row){
      this.param = row;
      this.deleteDialogVisible = true;
    },
    doDelete(){
      this.$axios.post("CourseInfoController/doDelete",this.param)
      .then(rst=>{
        let resultJson = rst.data;
        if(resultJson.code == 200){
          this.$message("操作成功！");
          this.search();
        }else {
          this.$message("操作失败！");
        }
        this.deleteDialogVisible= false;
      }).catch(err=>{
        console.log(err);
      })
    },
    showEditDialog(row){
      this.param = row;
      this.editDialogVisible = true;
    },
    doEdit(){
      this.$axios.post("CourseInfoController/update",this.param)
          .then(rst=>{
            let resultJson=rst.data;
            if(resultJson.code==200){
              this.$message("操作成功!");
              this.search();
            }else{
              this.$message("操作失败!")
            }
            this.editDialogVisible=false;
          }).catch(err=>{
        console.log(err)
      })
    }

  }
}
</script>

<style scoped>
#searchCourseContent{
  margin: 20px;
}
#searchCourseResult{
  margin: 20px;
}
#searchCourseResult a{
  margin-right: 5px;
}
#editCourseContainer{
  margin-right: 50px;
}
#editCourseContainer .el-select{
  width: 100%;
}
</style>