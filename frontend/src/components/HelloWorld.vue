<template>
  <div>
    <PostForm></PostForm>
    <PostItem></PostItem>
    <UserRegister></UserRegister>
    <UserLogin></UserLogin>
  </div>
</template>

<script>
import PostForm from './PostForm';
import PostItem from './PostItem';
import UserRegister from './UserRegister';
import UserLogin from './UserLogin';

export default {
  components: {
    PostForm,
    PostItem,
    UserRegister,
    UserLogin,
  },
  name: 'HelloWorld',
  data() {
    return {
      msg: 'Welcome to Your Vue.js App',
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
