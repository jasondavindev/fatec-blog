<template>
  <div id="app">
    <Topbar v-if="userExists()"></Topbar>
    <router-view />
  </div>
</template>

<script>
import Topbar from './components/Topbar';
import userMixin from './mixins/user';

export default {
  name: 'App',

  mixins: [userMixin],

  components: {
    Topbar,
  },
};
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>
