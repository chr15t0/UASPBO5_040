-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 11, 2023 at 06:48 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `Title` varchar(255) NOT NULL,
  `Author` varchar(255) NOT NULL,
  `Publisher` varchar(255) NOT NULL,
  `YearPublished` int(255) NOT NULL,
  `Type` varchar(255) NOT NULL,
  `Genre` varchar(255) NOT NULL,
  `Topic` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `Title`, `Author`, `Publisher`, `YearPublished`, `Type`, `Genre`, `Topic`) VALUES
(1, 'The Shadow of the Wind', 'Carlos Ruiz Zafón', 'Penguin Books', 2004, 'Fiction', 'Historical Fiction, Mystery', ''),
(2, '1984', 'George Orwell', 'Secker & Warburg', 1949, 'Fiction', 'Dystopian Fiction', ''),
(3, 'Pride and Prejudice', 'Jane Austen', 'Thomas Egerton', 1813, 'Fiction', 'Romance, Classic Literature', ''),
(4, 'The Lord of the Rings', 'J.R.R. Tolkien', 'George Allen & Unwin', 1955, 'Fiction', 'Fantasy, Epic Fiction', ''),
(5, 'To Kill a Mockingbird', 'Harper Lee', 'J. B. Lippincott & Co.', 1960, 'Fiction', 'Coming-of-Age, Legal Drama', ''),
(6, 'Harry Potter and the Philosopher\'s Stone', 'J.K. Rowling', 'Bloomsbury Publishing', 1997, 'Fiction', 'Fantasy, Young Adult Fiction', ''),
(7, 'The Great Gatsby', 'F. Scott Fitzgerald', 'Charles Scribner\'s Sons', 1925, 'Fiction', 'Literary Fiction, Jazz Age', ''),
(8, 'The Catcher in the Rye', 'J.D. Salinger', 'Little, Brown and Company', 1951, 'Fiction', 'Coming-of-Age, Literary Fiction', ''),
(9, 'Brave New World', 'Aldous Huxley', 'Chatto & Windus', 1932, 'Fiction', 'Dystopian Fiction, Science Fiction', ''),
(10, 'The Hobbit', 'J.R.R. Tolkien', 'George Allen & Unwin', 1937, 'Fiction', 'Fantasy, Adventure', ''),
(11, 'Sapiens: A Brief History of Humankind', 'Yuval Noah Harari', 'Harvill Secker', 2011, 'Non-Fiction', '', 'Anthropology, History'),
(12, 'The Immortal Life of Henrietta Lacks', 'Rebecca Skloot', 'Crown Publishing Group', 2010, 'Non-Fiction', '', 'Science, Medical Ethics'),
(13, 'Becoming', 'Michelle Obama', 'Crown Publishing Group', 2018, 'Non-Fiction', '', 'Autobiography, Memoir'),
(14, 'Sapiens: A Graphic History', 'Yuval Noah Harari, David Vandermeulen, Daniel Casanave', 'Harper Perennial', 2021, 'Non-Fiction', '', 'Graphic Novel, History'),
(15, 'The Gene: An Intimate History', 'Siddhartha Mukherjee', 'Scribner', 2016, 'Non-Fiction', '', 'Genetics, Medical History'),
(16, 'Educated: A Memoir', 'Tara Westover', 'Random House', 2018, 'Non-Fiction', '', 'Autobiography, Education'),
(17, 'Thinking, Fast and Slow', 'Daniel Kahneman', 'Farrar, Straus and Giroux', 2011, 'Non-Fiction', '', 'Psychology, Behavioral Economics'),
(18, 'Sapiens: A Graphic Guide', 'Yuval Noah Harari, David Vandermeulen, Daniel Casanave', 'Harper Perennial', 2021, 'Non-Fiction', '', 'Graphic Novel, Anthropology'),
(19, 'The Power of Now: A Guide to Spiritual Enlightenment', 'Eckhart Tolle', 'New World Library', 1997, 'Non-Fiction', '', 'Spirituality, Self-Help'),
(20, 'Quiet: The Power of Introverts in a World That Can\'t Stop Talking', 'Susan Cain', 'Crown Publishing Group', 2012, 'Non-Fiction', '', 'Psychology, Introversion\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `no.` int(11) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `user_type` enum('Admin','User') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`no.`, `Username`, `Password`, `user_type`) VALUES
(1, 'admin', 'admin', 'Admin'),
(2, 'christo', 'christo', 'User'),
(3, 'Admin', 'admin1', 'User'),
(4, 'admin', 'admin2', 'User'),
(5, 'Christian', 'Christian', 'User'),
(6, 'Vigo', 'vigo', 'User'),
(7, 'Johanes', 'Johanes', 'User'),
(8, 'Sohmono', 'Sohmono', 'User'),
(9, 'felix', 'felix', 'User');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`no.`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `no.` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
