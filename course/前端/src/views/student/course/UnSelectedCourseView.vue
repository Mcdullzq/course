<template>
	<div id="unSelectContainer">
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
				<el-table-column label="序号" prop="tcId"></el-table-column>
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
				<el-table-column label="操作">
					<template #default="scope">
						<router-link to="#" @click="showDialog(scope.row)">选择</router-link>
					</template>
				</el-table-column>
			</el-table>
		</div>
	</div>
	<!-- 选择提示框 -->
	  <el-dialog
	    v-model="centerDialogVisible"
	    title="提示"
	    width="30%"
	    align-center
	  >
	    <span>你确定要选择【{{course.teaName}}】教的【{{course.courseName}}】课吗?</span>
	    <template #footer>
	      <span class="dialog-footer">
	        <el-button @click="centerDialogVisible = false">取消</el-button>
	        <el-button type="primary" @click="doSelect">
	          确定
	        </el-button>
	      </span>
	    </template>
	  </el-dialog>
</template>

<script>
	export default{
		name:'UnSelectedCourseView',
		data() {
			return{
				courses:[],
				param:{
					courseName:'',
					teaName:'',
					stuId:''
				},
				stu:[],
				centerDialogVisible:false,
				course:{}
			}
		},
		methods:{
			search(){
				let str=sessionStorage.getItem("stu");
				this.stu=JSON.parse(str);
				this.param.stuId=this.stu.stuId;
				this.$axios.post("STCInfoController/findUnSelectedCourse",this.param)
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
			doSelect(){
				let m={stuId:this.stu.stuId,tcId:this.course.tcId};
				this.$axios.post("STCInfoController/save",m)
				.then(rst=>{
					if(rst.data.code==200){
						this.$message("选课成功!");
						this.search();
					}else{
						this.$message("选课失败!");
					}
					this.centerDialogVisible=false;
				})
			}
		}
	}
</script>

<style scoped>
	#searchResult,#searchContent{
		margin: 20px;
	}
</style>