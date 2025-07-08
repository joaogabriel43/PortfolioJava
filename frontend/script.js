document.addEventListener('DOMContentLoaded', () => {
    fetchProfile();
    fetchProjects();
    fetchCertificates();

    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('active');
            }
        });
    }, {
        threshold: 0.1
    });

    // É preciso um pequeno delay para garantir que os elementos já foram adicionados ao DOM pelo fetch
    setTimeout(() => {
        const revealElements = document.querySelectorAll('.reveal');
        revealElements.forEach(el => observer.observe(el));
    }, 500); // 500ms de delay

    const contactForm = document.getElementById('contact-form');
    if (contactForm) {
        contactForm.addEventListener('submit', handleFormSubmit);
    }
});

function fetchProfile() {
    fetch('http://localhost:8080/api/profile')
        .then(response => response.json())
        .then(data => {
            if (data) {
                document.getElementById('name-title').textContent = data.name;
                document.getElementById('job-title').textContent = data.title;
                document.getElementById('summary').textContent = data.summary;
            }
        })
        .catch(error => console.error('Erro ao buscar perfil:', error));
}

function fetchProjects() {
    fetch('http://localhost:8080/api/projects')
        .then(response => response.json())
        .then(data => {
            const projectList = document.getElementById('project-list');
            if (!projectList) return;
            projectList.innerHTML = '';
            data.forEach(project => {
                const projectCard = document.createElement('div');
                projectCard.className = 'card reveal';

                projectCard.innerHTML = `
                    <h3>${project.title}</h3>
                    <p>${project.description}</p>
                    <p><strong>Tecnologias:</strong> ${project.technologies}</p>
                    <div class="card-footer">
                        <a href="${project.sourcecodelink}" target="_blank">Ver Código Fonte</a>
                    </div>
                `;
                projectList.appendChild(projectCard);
            });
        })
        .catch(error => console.error('Erro ao buscar projetos:', error));
}

function fetchCertificates() {
    fetch('http://localhost:8080/api/certificates')
        .then(response => response.json())
        .then(data => {
            const certificateList = document.getElementById('certificate-list');
            if (!certificateList) return;
            certificateList.innerHTML = '';
            data.forEach(cert => {
                const certCard = document.createElement('div');
                certCard.className = 'card reveal';

                certCard.innerHTML = `
                    <h3>${cert.title}</h3>
                    <p><strong>Emissor:</strong> ${cert.issuer}</p>
                    <p><strong>Data:</strong> ${new Date(cert.date).toLocaleDateString('pt-BR', {timeZone: 'UTC'})}</p>
                `;
                certificateList.appendChild(certCard);
            });
        })
        .catch(error => console.error('Erro ao buscar certificados:', error));
}

async function handleFormSubmit(event) {
    event.preventDefault();
    const form = event.target;
    const status = document.getElementById('form-status');
    const button = form.querySelector('button');
    const data = { name: form.name.value, email: form.email.value, message: form.message.value };

    button.disabled = true;
    status.style.color = 'var(--text-secondary-color)';
    status.textContent = 'Enviando...';

    try {
        const response = await fetch('http://localhost:8080/api/contact', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });
        if (response.ok) {
            status.style.color = 'var(--primary-color)';
            status.textContent = 'Mensagem enviada com sucesso!';
            form.reset();
        } else {
            throw new Error('Falha no envio do formulário.');
        }
    } catch (error) {
        console.error('Erro no formulário:', error);
        status.style.color = '#FF4136';
        status.textContent = 'Ocorreu um erro ao enviar. Tente novamente.';
    } finally {
        setTimeout(() => {
            button.disabled = false;
            status.textContent = '';
        }, 3000);
    }
}