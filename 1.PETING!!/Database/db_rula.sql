-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 01 Bulan Mei 2023 pada 12.47
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_rula`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_adjustdata`
--

CREATE TABLE `t_adjustdata` (
  `nim` varchar(30) NOT NULL,
  `upperarm` varchar(15) NOT NULL,
  `a_upperarm` varchar(15) NOT NULL,
  `lowerarm` varchar(15) NOT NULL,
  `a_lowerarm` varchar(15) NOT NULL,
  `wrist` varchar(15) NOT NULL,
  `a_wrist` varchar(15) NOT NULL,
  `wristtwist` varchar(15) NOT NULL,
  `armwrist_muscle` varchar(15) NOT NULL,
  `a_armwrist_muscle` varchar(15) NOT NULL,
  `location_neck` varchar(15) NOT NULL,
  `a_location_neck` varchar(15) NOT NULL,
  `locate_trunk` varchar(15) NOT NULL,
  `a_locate_trunk` varchar(15) NOT NULL,
  `legs` varchar(15) NOT NULL,
  `necktrunklegs_muscle` varchar(15) NOT NULL,
  `a_necktrunklegs_muscle` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `t_adjustdata`
--

INSERT INTO `t_adjustdata` (`nim`, `upperarm`, `a_upperarm`, `lowerarm`, `a_lowerarm`, `wrist`, `a_wrist`, `wristtwist`, `armwrist_muscle`, `a_armwrist_muscle`, `location_neck`, `a_location_neck`, `locate_trunk`, `a_locate_trunk`, `legs`, `necktrunklegs_muscle`, `a_necktrunklegs_muscle`) VALUES
('21552011170', '3', '1', '2', '1', '2', '1', '1', '4', '0', '2', '2', '4', '2', '2', '4', '1');

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_rula`
--

CREATE TABLE `t_rula` (
  `nim` varchar(30) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `umur` varchar(10) NOT NULL,
  `pekerjaan` varchar(50) NOT NULL,
  `jeniskelamin` varchar(30) NOT NULL,
  `notelepon` varchar(30) NOT NULL,
  `upperarm` varchar(10) NOT NULL,
  `lowerarm` varchar(15) NOT NULL,
  `wrist` varchar(15) NOT NULL,
  `wristtwist` varchar(15) NOT NULL,
  `armwrist_muscle` varchar(15) NOT NULL,
  `location_neck` varchar(15) NOT NULL,
  `locate_trunk` varchar(15) NOT NULL,
  `legs` varchar(15) NOT NULL,
  `necktrunklegs_muscle` varchar(15) NOT NULL,
  `final_score` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `t_rula`
--

INSERT INTO `t_rula` (`nim`, `nama`, `alamat`, `umur`, `pekerjaan`, `jeniskelamin`, `notelepon`, `upperarm`, `lowerarm`, `wrist`, `wristtwist`, `armwrist_muscle`, `location_neck`, `locate_trunk`, `legs`, `necktrunklegs_muscle`, `final_score`) VALUES
('21552011170', 'Muhammad Dila', 'Jl. Cempaka 1 No. 33', '20', 'Pelajar', 'Laki-laki', '081395691727', '3', '3', '3', '1', '3', '3', '5', '2', '4', '7');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `t_adjustdata`
--
ALTER TABLE `t_adjustdata`
  ADD PRIMARY KEY (`nim`);

--
-- Indeks untuk tabel `t_rula`
--
ALTER TABLE `t_rula`
  ADD PRIMARY KEY (`nim`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `t_adjustdata`
--
ALTER TABLE `t_adjustdata`
  ADD CONSTRAINT `t_adjustdata_ibfk_1` FOREIGN KEY (`nim`) REFERENCES `t_rula` (`nim`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
