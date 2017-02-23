CREATE TABLE users_roles (
  user_id INT NOT NULL,
  RoleId INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (RoleId) REFERENCES roles(id)
);

