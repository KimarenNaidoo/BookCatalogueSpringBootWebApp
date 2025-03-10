import axios from 'axios';

const API_URL = '/api/books';

class BookService {

    getAllBooks() {
        return axios.get(API_URL);
    }

    getBook(id) {
        return axios.get(`${API_URL}/${id}`);
    }
}

export default new BookService();