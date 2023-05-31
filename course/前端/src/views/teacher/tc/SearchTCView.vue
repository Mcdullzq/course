<template>
	<div id="searchTCContainer">
		<div id="searchContent">
			<el-form :inline="true">
				<el-form-item label="课程名称:">
					<el-select v-model="tc.courseId">
						<el-option label="所有课程" value="0"></el-option>
						<el-option v-for="c in courses" :label="c.courseName" :value="c.courseId"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="教师姓名:">
					<el-select v-model="tc.teaId">
						<el-option label="所有教师" value="0"></el-option>
						<el-option v-for="t in teas" :label="t.teaName" :value="t.teaId"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item>
					<el-button @click="search">查询</el-button>
				</el-form-item>
			</el-form>
		</div>
		<div id="searchResult">
			<el-table :data="tcs" border>
				<el-table-column label="序号" prop="tcId"></el-table-column>
				<el-table-column label="课程名称" prop="courseName"></el-table-column>
				<el-table-column label="学分" prop="courseCredit"></el-table-column>
				<el-table-column label="考核方式">
					<template #default="scope">
						{{scope.row.courseExamMethod==2?'考试':'考察'}}
					</template>
				</el-table-column>
				<el-table-column label="教师名称" prop="teaName"></el-table-column>
				<el-table-column label="教室位置" prop="classroomLocation"></el-table-column>
				<el-table-column label="教室名称" prop="classroomName"></el-table-column>
				<el-table-column label="可容纳人数" prop="classroomNumber"></el-table-column>
				<el-table-column label="操作">
					<template #default="scope">
						<router-link to="#" @click="showDeleteDialog(scope.row)">删除</router-link>
					</template>
				</el-table-column>
			</el-table>
		</div>
	</div>
	<!-- 删除的对话框 -->
	  <el-dialog
	    v-model="deleteDialogVisible"
	    title="提示"
	    width="30%"
	    align-center
	  >
	    <span>您确定要删除【{{param.teaName}}的{{param.courseName}}】这门课吗?</span>
	    <template #footer>
	      <span class="dialog-footer">
	        <el-button @click="deleteDialogVisible = false">取消</el-button>
	        <el-button type="primary" @click="doDelete">
	          确定
	        </el-button>
	      </span>
	    </template>
	  </el-dialog>
</template>

<script>
	export default {
		name: 'SearchTVView',
		data() {
			return {
				tc: {
					teaId: '0',
					courseId: '0'
				},
				courses: [],
				teas: [],
				tcs:[],
				deleteDialogVisible:false,
				param:{}
			}
		},
		created() {
			this.$axios.post("CourseInfoController/findByParam", {
					courseStatus: 1
				})
				.then(rst => {
					this.courses = rst.data.data
				}).catch(err => {
					console.log(err);
				})

			this.$axios.post("TeaInfoController/findByParam", {
					teaStatus: 1,
					teaType: 2
				})
				.then(rst => {
					this.teas = rst.data.data;
				}).catch(err => {
					console.log(err);
				})
		},
		methods:{
			search(){
				this.$axios.post("TeachCourseInfoController/findByParam",this.tc)
				.then(rst=>{
					this.tcs=rst.data.data;
				}).catch(err=>{
					console.log(err);
				})
			},
			showDeleteDialog(row){
				this.param=row;
				this.deleteDialogVisible=true;
			},
			doDelete(){
				this.$axios.post("TeachCourseInfoController/delete",this.param)
				.then(rst=>{
					if(rst.data.code){
						this.$message("操作成功!")
						this.search();
					}else{
						this.$message("操作失败!")
					}
					this.deleteDialogVisible=false;
				})
			}
		}
	}
</script>

<style scoped>
	#searchContent,#searchResult {
		margin: 20px;
	}
</style>
