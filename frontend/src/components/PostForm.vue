<template>
  <div class="m-4 text-left">
    <b-card title="Criar um post">
      <b-form @submit.prevent="onSubmit">
        <div>
          <b-form-input v-model="postTitle" placeholder="Título"></b-form-input>
        </div>
        <div class="mt-2">
          <b-form-textarea
            id="textarea"
            v-model="postContent"
            placeholder="Escreva seus post"
            rows="3"
            max-rows="6"
          ></b-form-textarea>
        </div>
        <div class="mt-3">
          <b-button type="submit" variant="outline-primary"
            >Criar post</b-button
          >
        </div>
      </b-form>
    </b-card>
  </div>
</template>

<script>
import BlogApi from '../services/api';

export default {
  data() {
    return {
      postTitle: '',
      postContent: '',
    };
  },
  methods: {
    async onSubmit() {
      if (!this.validatePost()) return;

      await this.createPost();
    },

    async createPost() {
      try {
        const { data } = await BlogApi.createPost({
          user: 1,
          title: this.postTitle,
          description: this.postContent,
        });

        console.log(data);
      } catch (error) {
        console.error(error);
      }
    },

    validatePost() {
      return this.postTitle && this.postContent;
    },
  },
};
</script>
