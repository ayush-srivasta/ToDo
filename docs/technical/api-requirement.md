# 📘 API Summary Table

| Endpoint            | Method | Description                           |
|---------------------|--------|---------------------------------------|
| **/v1/auth/google** | POST   | Authenticate user via Google ID token |
| **/v1/users/me**    | GET    | Get current logged-in user            |
| **/v1/users/me**    | PATCH  | Update user profile                   |

## Group APIs
| Endpoint                                    | Method | Description                    |
|---------------------------------------------|--------|--------------------------------|
| **/v1/groups**                              | POST   | Create a new group             |
| **/v1/groups**                              | GET    | Get groups the user belongs to |
| **/v1/groups/{group_id}**                   | GET    | Get group details + members    |
| **/v1/groups/{group_id}/join**              | POST   | Join group using invite        |
| **/v1/groups/{group_id}/members/{user_id}** | DELETE | Remove a group member          |

## Group Members
| Endpoint                          | Method | Description        |
|-----------------------------------|--------|--------------------|
| **/v1/groups/{group_id}/members** | GET    | List group members |

## Lists APIs
| Endpoint                | Method | Description                           |
|-------------------------|--------|---------------------------------------|
| **/v1/lists**           | POST   | Create a new list (personal or group) |
| **/v1/lists**           | GET    | Get all accessible lists              |
| **/v1/lists/{list_id}** | GET    | Get list details + items              |
| **/v1/lists/{list_id}** | PATCH  | Update list metadata                  |
| **/v1/lists/{list_id}** | DELETE | Delete list                           |

## Items APIs
| Endpoint                      | Method | Description             |
|-------------------------------|--------|-------------------------|
| **/v1/lists/{list_id}/items** | POST   | Create a new item       |
| **/v1/lists/{list_id}/items** | GET    | Get all items in a list |
| **/v1/items/{item_id}**       | PATCH  | Update item             |
| **/v1/items/{item_id}**       | DELETE | Delete item             |

## Offline Sync APIs
| Endpoint                | Method | Description                               |
|-------------------------|--------|-------------------------------------------|
| **/v1/sync/operations** | POST   | Submit offline operations batch           |
| **/v1/sync/changes**    | GET    | Fetch incremental updates since last sync |


## Metadata APIs
| Endpoint                | Method | Description                    |
|-------------------------|--------|--------------------------------|
| **/v1/meta/list-types** | GET    | List supported list categories |
| **/v1/meta/priorities** | GET    | List supported priority levels |

