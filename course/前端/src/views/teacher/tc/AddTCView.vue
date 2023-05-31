<template>
	<div id="addTCContainer">
		<el-form label-width="120px">
			<el-form-item label="课程名称:">
				<el-select v-model="tc.courseId" @change="findByCourseId">
					<el-option label="请选择课程" value="0"></el-option>
					<el-option v-for="c in courses" :label="c.courseName" :value="c.courseId"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="任课教师:">
				<el-select v-model="tc.teaId">
					<el-option label="请选择任课老师" value="0"></el-option>
					<el-option v-for="t in teas" :label="t.teaName" :value="t.teaId"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="上课地址:">
				<el-col :span="11">
					<el-select v-model="tc.classId" @change="findByLocation">
						<el-option label="请选择楼号" value="0"></el-option>
						<el-option v-for="c in rooms" :label="c.classroomLocation" :value="c.classroomLocation"></el-option>
					</el-select>
				</el-col>
				<el-col :span="2"></el-col>
				<el-col :span="11">
					<el-select v-model="tc.classroomId">
						<el-option label="请选择教室" value="0"></el-option>
						<el-option v-for="c in classrooms" :label="c.classroomName" :value="c.classroomId"></el-option>
					</el-select>
				</el-col>
			</el-form-item>
			<el-form-item>
				<el-button @click="doSave">添加</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default{
		name:'AddTCView',
		data() {
			return{
				tc:{
					courseId:'0',
					teaId:'0',
					classroomId:'0',
					classId:'0'
				},
				courses:[],
				teas:[],
				rooms:[],
				classrooms:[]
			}
		},
		created() {
			let course={courseStatus:1};
			this.$axios.post("CourseInfoController/findByParam",course)
			.then(rst=>{
				this.courses=rst.data.data;
			}).catch(err=>{
				console.log(err);
			})
			
			this.$axios.post("ClassroomInfoController/findAllLocation")
			.then(rst=>{
				this.rooms=rst.data.data;
			}).catch(err=>{
				console.log(err)
			})
		},
		methods:{
			findByCourseId(){
				this.$axios.post("TeaInfoController/findByCourseId",this.tc)
				.then(rst=>{
					this.teas=rst.data.data;
				}).catch(err=>{
					console.log(err)
				})
			},
			findByLocation(){
				this.$axios.post("ClassroomInfoController/findByLocation",this.tc)
				.then(rst=>{
					this.classrooms=rst.data.data;
				}).catch(err=>{
					console.log(err)
				})
			},
			doSave(){
				this.$axios.post("TeachCourseInfoController/save",this.tc)
				.then(rst=>{
					if(rst.data.code==200){
						this.$message("操作成功!");
            this.tc={
              courseId:'0',
              teaId:'0',
              classroomId:'0',
              classId:'0'
            }
					}else{
						this.$message("操作失败!")
					}
				})
			}
		}
	}
</script>

<style scoped>
	#addTCContainer{
		width: 450px;
		margin-top: 20px;
	}
	.el-select{
		width: 100%;
	}
</style>