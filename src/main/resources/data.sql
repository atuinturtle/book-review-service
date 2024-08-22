-- Create the users table
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       email VARCHAR(100) UNIQUE NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the genres table
CREATE TABLE genres (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(50) UNIQUE NOT NULL
);

-- Create the books table
CREATE TABLE books (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       author VARCHAR(255) NOT NULL,
                       description TEXT,
                       genre_id INT,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (genre_id) REFERENCES genres(id)
);

-- Create the reviews table
CREATE TABLE reviews (
                         id SERIAL PRIMARY KEY,
                         user_id INT,
                         book_id INT,
                         rating INT CHECK (rating >= 1 AND rating <= 5),
                         review_text TEXT,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (user_id) REFERENCES users(id),
                         FOREIGN KEY (book_id) REFERENCES books(id)
);

-- Insert initial data into the users table
INSERT INTO users (username, email, password) VALUES
                                                  ('john_doe', 'john.doe@example.com', 'hashed_password1'),
                                                  ('jane_smith', 'jane.smith@example.com', 'hashed_password2');

-- Insert initial data into the genres table
INSERT INTO genres (name) VALUES
                              ('Science Fiction'),
                              ('Fantasy'),
                              ('Non-Fiction'),
                              ('Mystery'),
                              ('Romance');

-- Insert initial data into the books table
INSERT INTO books (title, author, description, genre_id) VALUES
                                                             ('Dune', 'Frank Herbert', 'A science fiction novel about the son of a noble family entrusted with the protection of the most valuable asset in the galaxy.', 1),
                                                             ('1984', 'George Orwell', 'A dystopian social science fiction novel and cautionary tale about the future.', 1),
                                                             ('The Hobbit', 'J.R.R. Tolkien', 'A fantasy novel about the journey of hobbit Bilbo Baggins.', 2),
                                                             ('Sapiens', 'Yuval Noah Harari', 'A brief history of humankind.', 3),
                                                             ('The Da Vinci Code', 'Dan Brown', 'A mystery thriller novel that explores an alternative religious history.', 4);

-- Insert initial data into the reviews table
INSERT INTO reviews (user_id, book_id, rating, review_text) VALUES
                                                                (1, 1, 5, 'An epic science fiction story that explores themes of politics, religion, and humanity.'),
                                                                (2, 2, 4, 'A haunting tale of a dystopian future. Thought-provoking and chilling.'),
                                                                (1, 3, 4, 'A delightful fantasy adventure with memorable characters.'),
                                                                (2, 4, 5, 'A fascinating exploration of human history. Insightful and engaging.'),
                                                                (1, 5, 3, 'A gripping mystery but a bit predictable at times.');

