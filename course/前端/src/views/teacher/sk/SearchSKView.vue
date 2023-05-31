<template>
	<div id="searchSKContainer">
		<el-table :data="sks" border>
			<el-table-column label="序号" prop="tcId"></el-table-column>
			<el-table-column label="课程名称" prop="courseName"></el-table-column>
			<el-table-column label="课程学分" prop="courseCredit"></el-table-column>
			<el-table-column label="考核方式">
				<template #default="scope">
					{{scope.row.courseExamMethod==1?'考察':'考试'}}
				</template>
			</el-table-column>
			<el-table-column label="上课地址">
				<template #default="scope">
					{{scope.row.classroomLocation}}{{scope.row.classroomName}}
				</template>
			</el-table-column>
			<el-table-column label="人数" prop="classroomNumber"></el-table-column>
		</el-table>
	</div>
</template>

<script>
	export default{
		name:'SearchSKView',
		data() {
			return{
				sks:[]
			}
		},
		created() {
			let str=sessionStorage.getItem("tea");
			let tea=JSON.parse(str);
			this.$axios.post("TeachCourseInfoController/findByParam",tea)
			.then(rst=>{
				this.sks=rst.data.data;
			}).catch(err=>{
				console.log(err)
			})
		}
	}
</script>

<style scoped>
	#searchSKContainer{
		margin: 20px;
	}
</style>