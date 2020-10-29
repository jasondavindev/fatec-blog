<template>
  <div class="posts-list" v-if="hasUser()">
    <PostsList></PostsList>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import PostsList from '../components/PostsList';

export default {
  name: 'Posts',

  components: {
    PostsList,
  },

  mounted() {
    if (!this.hasUser()) {
      this.$router.push({ name: 'Login' });
    }
  },

  computed: {
    ...mapGetters(['user']),
  },

  methods: {
    hasUser() {
      const { id } = this.user;
      return id;
    },
  },
};
</script>

<style>
</style>
