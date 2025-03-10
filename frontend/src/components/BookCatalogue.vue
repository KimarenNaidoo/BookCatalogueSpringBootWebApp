<template>
  <div>
    <h1>Book Catalogue</h1>
    <div v-if="loading">Loading...</div>
    <div v-else>
      <div v-if="error" class="error">{{ error }}</div>
      <ul v-else class="book-list">
        <li v-for="book in books" :key="book.id" class="book-item">
          <h3>{{ book.title }}</h3>
          <p>{{ book.author }}</p>
        </li>
      </ul>
    </div>
  </div>  
</template>

<script>

import BookService from '@/service/bookService';

export default {
  name: 'BookCatalogue',
  data() {
    return {
      books: [],
      loading: true,
      error: null
    };
  },
  mounted() {
    this.fetchBooks();
  },
  methods: {
    fetchBooks() {
      this.loading = true;
      BookService.getAllBooks()
        .then(response => {
          this.books = response.data;
          this.loading = false;
        })
        .catch(error => {
          this.error = 'Error fetching books: ' + error.message;
          this.loading = false;
          console.error('Error fetching books: ' + error);
        });
    }
  }
};
</script>


