var TimeLimitedCache = function() {
    const cache = new Map();

    this.set = function(key, value, duration) {
        const currentTime = Date.now();

        let alreadyExists = false;

        if (cache.has(key)) {
            const oldData = cache.get(key);

            if (oldData.expiresAt > currentTime) {
                alreadyExists = true;
            }
        }

        cache.set(key, {
            value: value,
            expiresAt: currentTime + duration
        });

        return alreadyExists;
    };

    this.get = function(key) {
        if (!cache.has(key)) {
            return -1;
        }

        const data = cache.get(key);

        if (Date.now() >= data.expiresAt) {
            cache.delete(key);
            return -1;
        }

        return data.value;
    };

    this.count = function() {
        let count = 0;
        const currentTime = Date.now();

        for (const [key, data] of cache) {
            if (data.expiresAt > currentTime) {
                count++;
            } else {
                cache.delete(key);
            }
        }

        return count;
    };
};