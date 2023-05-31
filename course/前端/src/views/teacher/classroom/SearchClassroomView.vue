<template>
<div id="searchContainer">
  <div id="searchContent">
    <el-form label-width="120px">
      <el-row>
        <el-col span="8">
          <el-form-item label="教师名称">
            <el-input placeholder="支持按照名称模糊查询" v-model="room.classroomName"></el-input>
          </el-form-item>
        </el-col>
        <el-col span="8">
          <el-form-item label="教室位置">
            <el-input placeholder="支持按照楼号模糊查询" v-model="room.classroomLocation"></el-input>
          </el-form-item>
        </el-col>
        <el-col span="8">
          <el-form-item label="教室状态" >
            <el-select  v-model="room.classroomStatus">
              <el-option label="所有" value="0"></el-option>
              <el-option label="可用" value="1"></el-option>
              <el-option label="禁用" value="2"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col span="16">
          <el-form-item label="人数范围">
            <el-col span="11">
              <el-input placeholder="人数下限" v-model="room.minNumber"></el-input>
            </el-col>
            <el-col span="2">
              <div style="text-align: center;">--</div>
            </el-col>
            <el-col span="11">
              <el-input placeholder="人数上限" v-model="room.maxNumber"></el-input>
            </el-col>
          </el-form-item>
        </el-col>
        <el-col span="8">
          <el-form-item>
            <el-button @click="search">查询</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
  <div id="searchResult">
    <el-table :data="rooms">
      <el-table-column label="序号" prop="classroomId"></el-table-column>
      <el-table-column label="教室名称" prop="classroomName"></el-table-column>
      <el-table-column label="教室位置" prop="classroomLocation"></el-table-column>
      <el-table-column label="教室容纳人数" prop="classroomNumber"></el-table-column>
      <el-table-column label="教室状态">
        <template #default="scope">
          <div :class="scope.row.classroomStatus==1?'green':'red'">
          {{scope.row.classroomStatus==1?'可用':'禁用'}}
          </div>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <router-link to="#" @click="showEditDialog(scope.row)">编辑</router-link>
          <router-link to="#" v-if="scope.row.classroomStatus==1" @click="updateStatus(scope.row,2)">禁用</router-link>
          <router-link to="#" v-if="scope.row.classroomStatus==2" @click="updateStatus(scope.row,1)">可用</router-link>
        </template>
      </el-table-column>
    </el-table>
  </div>
</div>
  <!--编辑的对话框 -->
  <div id="editDialogContent">
    <el-dialog
        v-model="centerDialogVisible"
        title="编辑"
        width="30%"
        align-center
    >
      <el-form label-width="120px">
        <el-form-item label="教室名称">
          <el-input v-model="param.classroomName"></el-input>
        </el-form-item>
        <el-form-item label="教室位置">
          <el-input v-model="param.classroomLocation"></el-input>
        </el-form-item>
        <el-form-item label="教室容纳人数">
          <el-input v-model="param.classroomNumber"></el-input>
        </el-form-item>
        <el-form-item label="教室状态：">
          <el-select v-model="param.classroomStatus">
            <el-option label="可用" :value="1"></el-option>
            <el-option label="禁用" :value="2"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
      <el-button @click="centerDialogVisible = false">取消</el-button>
      <el-button type="primary" @click="doEdit">
        确定
      </el-button>
      </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "SearchClassroomView",
  data(){
    return{
      room:{
        classroomName:'',
        classroomLocation:'',
        classroomStatus:'0',
        minNumber:'',
        maxNumber:''
      },
      rooms:[],
      param:{},
      centerDialogVisible:false,
    }
  },
  methods:{
    search(){
      this.$axios.post("ClassroomInfoController/search",this.room)
      .then(rst=>{
        this.rooms = rst.data.data;
      }).catch(err=>{
        console.log(err);
      })
    },
    updateStatus(row,status){
      this.param = row;
      this.param.classroomStatus = status;
      this.$axios.post("ClassroomInfoController/updateStatus",this.param)
      .then(rst=>{
        let resultJson = rst.data;
        if(resultJson.code == 200){
          this.$message("更改成功");
          this.search();
        }else{
          this.$message("更改失败");
        }
      })
    },
    showEditDialog(row){
      this.param = row;
      this.centerDialogVisible=true;
    },
    doEdit(){
      this.$axios.post("ClassroomInfoController/update",this.param)
      .then(rst=>{
        let resultJson = rst.data;
        if(resultJson.code == 200){
          this.$message("更新成功！");
          this.search();
          this.centerDialogVisible =false;
        }else{
          this.$message("更新失败！");
        }
      }).catch(err=>{
        console.log(err);
      })
    }
  }
}
</script>

<style scoped>
  #searchContent{
    width: 1200px;
    margin-top: 20px;
  }
  #searchResult{
    margin: 20px;
  }
  #searchResult a{
    margin-right: 5px;
  }
  .red{
    color: red;
     }
  .green{
    color: green;
  }
  #editDialogContent{
    margin-right:50px;
  }
  #editDialogContent .el-select{
    width: 100%;
  }
</style>