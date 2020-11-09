<template>
  <b-card title="Comentar">
    <b-form @submit.prevent="createComment">
      <b-form-input v-model="commentary" placeholder="Escreva seu comentário" />
      <b-button
        v-if="!sent"
        class="mt-2"
        variant="outline-primary"
        type="submit"
        >Enviar</b-button
      >
    </b-form>
  </b-card>
</template>

<script>
import { mapGetters } from 'vuex';
import BlogApi from '../services/api';
import userMixin from '../mixins/user';

export default {
  mixins: [userMixin],

  computed: {
    ...mapGetters(['user']),
  },

  props: ['post'],

  data() {
    return {
      commentary: null,
      sent: false,
    };
  },

  created() {
    if (!this.userExists()) {
      this.$router.push('/login');
    }
  },

  methods: {
    async createComment() {
      console.log(this.commentary);
      try {
        this.sent = true;

        await BlogApi.createComment({
          commentary: this.commentary,
          post: this.post,
          user: this.user.id,
        });

        this.emitCommentCreate(this.commentary);
        this.commentary = '';
      } catch (error) {
      } finally {
        this.sent = false;
      }
    },

    emitCommentCreate(commentary) {
      this.$emit('commentCreate', commentary);
    },
  },
};
</script>

<style>
</style>
