### 🏗️ Feature Roadmap

#### **Step 1: Basic Server**

- Start Java server on a port
- Accept a single connection
- Send “Welcome!”
- Close connection
    

#### **Step 2: Add Commands**

Implement commands:
```txt
LIST  → returns file names  
GET   → sends file bytes  
PUT   → receives file and saves  
```
#### **Step 3: More features**
- Add simple authentication (username/password)
- Add multi-threading for multiple connections
- Add checksums


#### **Step 4: Add QoL**
- upload muliple files
- download multiple files
- Add parallel connections for faster uploads/downloads
- Add progress bar for downloads
- Add logging
    

#### **Additional goals**

- Build a simple GUI client with JavaFX
- Add encryption (AES)
- Add resume-if-interrupted downloads
- Add synchronization
- Implement simple directory permission solution
- Share files by link
- Server configuration file instead of hardcoding
