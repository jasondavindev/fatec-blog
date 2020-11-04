<template>
  <div class="m-4 text-left">
    <b-card title="Criar post">
      <b-form @submit.prevent="onSubmit">
        <div>
          <b-form-input v-model="postTitle" placeholder="Título"></b-form-input>
        </div>
        <div class="mt-2">
          <b-form-textarea
            id="post-content"
            v-model="postContent"
            placeholder="Escreva seus post"
            rows="3"
            max-rows="6"
          ></b-form-textarea>
        </div>
        <div class="mt-3" v-if="!sent">
          <b-button type="submit" variant="outline-primary"
            >Criar post</b-button
          >
        </div>
      </b-form>
    </b-card>

    <div class="mt-2">
      <b-alert variant="success" v-model="created"
        >Post criado com sucesso!</b-alert
      >
    </div>
  </div>
</template>

<script>
import BlogApi from '../services/api';

export default {
  data() {
    return {
      postTitle: '',
      postContent: '',
      created: false,
      sent: false,
    };
  },
  methods: {
    async onSubmit() {
      if (!this.validatePost()) return;

      await this.createPost();
    },

    async createPost() {
      this.sent = true;

      try {
        const { data } = await BlogApi.createPost({
          user: 1,
          title: this.postTitle,
          description: this.postContent,
        });

        this.created = true;
        setTimeout(this.redirectToPosts, 1000);
      } catch (error) {
        this.sent = false;
      }
    },

    validatePost() {
      return this.postTitle && this.postContent;
    },

    redirectToPosts() {
      this.$router.push({ name: 'Posts' });
    },
  },
};
</script>
