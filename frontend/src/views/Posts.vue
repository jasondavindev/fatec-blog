<template>
  <div class="posts-list m-2" v-if="userExists()">
    <b-card>
      <h4>
        Olá {{ user.name }}. Você quer criar um Post? É claro que sim, vamos lá
        então!!
      </h4>
      <b-button @click="createPost" variant="primary">Criar post</b-button>
    </b-card>

    <PostsList></PostsList>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import userMixin from '../mixins/user';
import PostsList from '../components/PostsList';

export default {
  name: 'Posts',

  mixins: [userMixin],

  components: {
    PostsList,
  },

  mounted() {
    if (!this.userExists()) {
      this.$router.push({ name: 'Login' });
    }
  },

  computed: {
    ...mapGetters(['user']),
  },

  methods: {
    createPost() {
      this.$router.push({ name: 'PostCreate' });
    },
  },
};
</script>

<style>
</style>
