<template>
	<div id="selectedCourseContainer">
		<div id="searchContent">
			<el-form :inline="true">
				<el-form-item label="课程名称:">
					<el-input v-model="param.courseName"></el-input>
				</el-form-item>
				<el-form-item label="教师姓名:">
					<el-input v-model="param.teaName"></el-input>
				</el-form-item>
				<el-form-item>
					<el-button @click="search">查询</el-button>
				</el-form-item>
			</el-form>
		</div>
		<div id="searchResult">
			<el-table :data="courses" border>
				<el-table-column label="序号" prop="stcId"></el-table-column>
				<el-table-column label="教师姓名" prop="teaName"></el-table-column>
				<el-table-column label="课程名称" prop="courseName"></el-table-column>
				<el-table-column label="学分" prop="courseCredit"></el-table-column>
				<el-table-column label="考核方式">
					<template #default="scope">
						{{scope.row.courseExamMethod==1?'考察':'考试'}}
					</template>
				</el-table-column>
				<el-table-column label="上课地址">
					<template #default="scope">
						{{scope.row.classroomLocation}} {{scope.row.classroomName}}
					</template>
				</el-table-column>
				<el-table-column label="分数" prop="stcScore"></el-table-column>
				<el-table-column label="操作">
					<template #default="scope">
						<router-link to="#" @click="showDialog(scope.row)" v-if="!scope.row.stcScore">退课</router-link>
					</template>
				</el-table-column>
			</el-table>
		</div>
	</div>
	<!-- 退课对话框 -->
	<el-dialog
	    v-model="centerDialogVisible"
	    title="提示"
	    width="30%"
	    align-center
	  >
	    <span>你确定要退出【{{course.teaName}}】教的【{{course.courseName}}】课吗?</span>
	    <template #footer>
	      <span class="dialog-footer">
	        <el-button @click="centerDialogVisible = false">取消</el-button>
	        <el-button type="primary" @click="doDelete">
	          确定
	        </el-button>
	      </span>
	    </template>
	  </el-dialog>
</template>

<script>
	export default{
		name:'SelectedCourseView',
		data() {
			return {
				courses:[],
				param:{
					courseName:'',
					teaName:'',
					stuId:''
				},
				stu:{},
				centerDialogVisible:false,
				course:{}
			}
		},
		methods:{
			search(){
				this.param.stuId=this.stu.stuId;
				this.$axios.post("STCInfoController/findSelectedCourse",this.param)
				.then(rst=>{
					this.courses=rst.data.data;
				}).catch(err=>{
					console.log(err)
				})
			},
			showDialog(row){
				this.course=row;
				this.centerDialogVisible=true;
			},
			doDelete(){
				this.$axios.post("STCInfoController/delete",this.course)
				.then(rst=>{
					if(rst.data.code==200){
						this.$message("退课成功");
						this.search();
					}else{
						this.$message("退课失败")
					}
					this.centerDialogVisible=false;
				})
			}
		},
		created(){
			let str=sessionStorage.getItem("stu");
			this.stu=JSON.parse(str);
		}
	}
</script>
<style scoped>
	#searchResult,#searchContent{
		margin: 20px;
	}
</style>