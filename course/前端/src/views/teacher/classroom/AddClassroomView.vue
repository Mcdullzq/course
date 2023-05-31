<template>
  <div id="roomcontainer">
    <el-form label-width="120px" size="large">
      <el-form-item label="教室名称：">
        <el-input placeholder="请输入教室名称或编号" v-model="room.classroomName"></el-input>
      </el-form-item>
      <el-form-item label="教室地址：">
        <el-input placeholder="请输入教室所在的楼号或名称" v-model="room.classroomLocation"></el-input>
      </el-form-item>
      <el-form-item label="最大容纳人数：">
        <el-input placeholder="请输入教室最大容纳的人数" v-model="room.classroomNumber"></el-input>
      </el-form-item>
      <el-button @click="doSave">添加</el-button>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "AddClassroomView",
  data(){
    return{
      room:{
        classroomName:'',
        classroomLocation:'',
        classroomNumber:''

      }
    }
  },
  methods:{
    doSave(){
      console.log(this.room);
    this.$axios.post("ClassroomInfoController/save",this.room)
      .then(rst=>{
        let resultJson = rst.data;
        if(resultJson.code==200){
          this.$message("添加成功！");
        }else {
          this.$message("添加失败！");
        }
      })
    }
  }
}

</script>

<style scoped>
  #roomcontainer{
    margin-top: 20px ;
    width: 400px;
  }
</style>