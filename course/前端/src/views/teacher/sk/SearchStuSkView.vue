<template>
	<div id="searchStuSkContainer">
		<div id="searchContent">
			<el-form :inline="true">
				<el-form-item label="课程名称:">
					<el-select v-model="course.courseId">
						<el-option label="所有" value="0"></el-option>
						<el-option v-for="c in sks" :label="c.courseName" :value="c.courseId"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item>
					<el-button @click="search">查询</el-button>
				</el-form-item>
			</el-form>
		</div>
		<div id="searchResult">
			<el-table :data="stus" border>
				<el-table-column label="序号" prop="stcId"></el-table-column>
				<el-table-column label="学生姓名" prop="stuName"></el-table-column>
				<el-table-column label="课程名称" prop="courseName"></el-table-column>
				<el-table-column label="课程分数" prop="stcScore"></el-table-column>
				<el-table-column label="操作">
					<template #default="scope">
						<router-link to="#" @click="showDialog(scope.row)">打分</router-link>
					</template>
				</el-table-column>
			</el-table>
		</div>
	</div>
	<!-- 打分的对话框 -->
	 <el-dialog
	    v-model="centerDialogVisible"
	    title="打分"
	    width="30%"
	    align-center
	  >
	    <div id="fsContainer">
			<el-form label-width="120px">
				<el-form-item label="姓名:">
					<el-input v-model="param.stuName"></el-input>
				</el-form-item>
				<el-form-item label="课程名称:">
					<el-input v-model="param.courseName"></el-input>
				</el-form-item>
				<el-form-item label="分数:">
					<el-input v-model="param.stcScore"></el-input>
				</el-form-item>
			</el-form>
		</div>
	    <template #footer>
	      <span class="dialog-footer">
	        <el-button @click="centerDialogVisible = false">取消</el-button>
	        <el-button type="primary" @click="setScore">
	          确定
	        </el-button>
	      </span>
	    </template>
	  </el-dialog>
</template>

<script>
	export default{
		name:'SearchStuSkView',
		data() {
			return{
				sks:[],
				course:{
					courseId:'0',
					teaId:''
				},
				stus:[],
				tea:{},
				centerDialogVisible:false,
				param:{}
			}
		},
		methods:{
			search(){
				this.course.teaId=this.tea.teaId;
				this.$axios.post("STCInfoController/findByParam",this.course)
				.then(rst=>{
					this.stus=rst.data.data;
				}).catch(err=>{
					console.log(err);
				})
			},
			showDialog(row){
				this.param=row;
				this.centerDialogVisible=true;
			},
			setScore(){
				this.$axios.post("STCInfoController/updateScore",this.param)
				.then(rst=>{
					if(rst.data.code==200){
						this.$message("分数设置成功!");
						this.centerDialogVisible=false;
						this.search();
					}else{
						this.$message("分数设置失败!");
					}
				})
			}
		},
		created() {
			let str=sessionStorage.getItem("tea");
			this.tea=JSON.parse(str);
			this.$axios.post("TeachCourseInfoController/findByParam",this.tea)
			.then(rst=>{
				this.sks=rst.data.data
			}).catch(err=>{
				console.log(err)
			})
		}
	}
</script>

<style scoped>
	#searchContent,#searchResult{
		margin: 20px;
	}
	#fsContainer{
		margin-right: 80px;
	}
</style>