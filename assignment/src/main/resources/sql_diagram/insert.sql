USE WebsellManager
GO

INSERT INTO employees([id], [name], [gender], [email], [birth], [address], [avartar], [password], [role]) VALUES
('PD05178', N'Nguyễn Ngọc Kha', 0, 'nhomchung1999@gmail.com', '1999-06-22', N'K341/18 Tôn Đức Thắng, Đà Nẵng', 'ngockha.jpg', '0907718993', 1),
('PD05170', N'Nguyễn Ngọc Xuân', 1, 'ngocxuan1999@gmail.com', '1999-03-23', N'Hẻm 144 Lý Tự Trọng, Đà Nẵng', 'ngocxuan.jpg', '1234567890', 0)



INSERT INTO categories([id], [type]) VALUES
(1000, N'Ứng dụng Website'),
(1001, N'Ứng dụng Android'),
(1002, N'Trí tuệ AI'),
(1003, N'Bộ đệm phần cứng'),
(1004, N'Ứng dụng phần mềm GUI')