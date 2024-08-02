-- Users table
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Books table
CREATE TABLE books (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       author VARCHAR(100) NOT NULL,
                       isbn VARCHAR(13) UNIQUE,
                       genre VARCHAR(50),
                       publication_date DATE,
                       description TEXT,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Reviews table
CREATE TABLE reviews (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         book_id BIGINT NOT NULL,
                         user_id BIGINT NOT NULL,
                         rating TINYINT NOT NULL,
                         review_text TEXT,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         FOREIGN KEY (book_id) REFERENCES books(id),
                         FOREIGN KEY (user_id) REFERENCES users(id)
);

-- User roles table (for basic role-based access control)
CREATE TABLE user_roles (
                            user_id BIGINT NOT NULL,
                            role VARCHAR(20) NOT NULL,
                            PRIMARY KEY (user_id, role),
                            FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Book genres table (for more flexible genre management)
CREATE TABLE genres (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(50) NOT NULL UNIQUE
);

-- Book-Genre relationship table (many-to-many)
CREATE TABLE book_genres (
                             book_id BIGINT NOT NULL,
                             genre_id BIGINT NOT NULL,
                             PRIMARY KEY (book_id, genre_id),
                             FOREIGN KEY (book_id) REFERENCES books(id),
                             FOREIGN KEY (genre_id) REFERENCES genres(id)
);