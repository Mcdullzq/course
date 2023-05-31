<template>
	<div id="addBatchStusContainer">
		<div id="fileContent">
			<el-upload
			   ref="upload"
			   class="upload-demo"
			   action=""
			   :limit="1"
			   :on-exceed="handleExceed"
			   :auto-upload="false"
			   accept=".xls"
			   v-model:file-list="fileList"
			 >
			   <template #trigger>
			     <el-button type="primary">选择上传的文件</el-button>
			   </template>
			   <el-button class="ml-3" type="success" @click="showFileContent">
			     显示内容
			   </el-button>
			   <el-button class="ml-3" type="success" @click="upLoad">
			     上传文件
			   </el-button>
				<el-button class="ml-3" type="success" @click="downLoad()">
				  下载模板
				</el-button>
			 </el-upload>
		</div>
		<div id="result">
			<el-table :data="stus" border>
				<el-table-column label="学生姓名" prop="name"></el-table-column>
				<el-table-column label="学生性别" prop="sex"></el-table-column>
				<el-table-column label="学生邮箱" prop="email"></el-table-column>
			</el-table>
		</div>
	</div>
</template>

<script>
	export default{
		name:'addBatchStusView',
		data(){
			return{
				stus:[],
				fileList:[]
			}
		},
		methods:{
			handleExceed(files){
				this.fileList=files;
			},
			downLoad(){
				location.href="http://localhost:8088/stuselectsystem/StuInfoController/downLoad";
			},
			showFileContent(){
				if(this.fileList.length==0){
					this.$message("请选择上传的文件!");
				}else{
					let formData=new FormData();
					formData.append("file",this.fileList[0].raw);
					this.$axios.post("StuInfoController/showFileContent",formData)
					.then(rst=>{
						this.stus=rst.data.data;
					}).catch(err=>{
						console.log(err)
					})
				}
			},
			upLoad(){
				this.$axios.post("StuInfoController/batchSave",this.stus)
				.then(rst=>{
					if(rst.data.code==200){
						this.$message("操作成功!");
						this.stus=[];
					}else{
						this.$message("操作失败!")
					}
				})
			}
		}
	}
</script>

<style scoped>
	#fileContent{
		margin: 20px;
	}
	#fileContent .el-button{
		margin-left:20px;
	}
</style>